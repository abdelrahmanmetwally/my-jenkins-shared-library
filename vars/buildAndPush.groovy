def call(Map config) {
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh "docker login -u ${config.USERNAME} -p ${config.PASSWORD}"
        sh "docker build -t ${config.DOCKER_REGISTRY}/${config.DOCKER_IMAGE}:v${config.BUILD_NUMBER} ${config.BUILD_PATH}"
        sh "docker push ${config.DOCKER_REGISTRY}/${config.DOCKER_IMAGE}:v${config.BUILD_NUMBER}"
    }
}
