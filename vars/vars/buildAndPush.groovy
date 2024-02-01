def call(Map config) {
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh "docker login -u ${USERNAME} -p ${PASSWORD}"
        sh "docker build -t ${config.DOCKER_REGISTRY}/${config.DOCKER_IMAGE}:v${config.BUILD_NUMBER} ."
        sh "docker push ${config.DOCKER_REGISTRY}/${config.DOCKER_IMAGE}:v${config.BUILD_NUMBER}"
    }
}
