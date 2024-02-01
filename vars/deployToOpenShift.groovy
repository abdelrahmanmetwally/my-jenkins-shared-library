def call(Map config) {
    withCredentials([file(credentialsId: 'openshift-credentials', variable: 'KUBECONFIG')]) {
        sh """
            oc login --token=${config.OPENSHIFT_TOKEN} --server=${config.SERVER_NAME} --insecure-skip-tls-verify
            oc project ${config.OPENSHIFT_PROJECT}
            oc apply -f DeployRoute.yml --kubeconfig ${config.KUBECONFIG} -n ${config.OPENSHIFT_PROJECT}
        """
    }
}
