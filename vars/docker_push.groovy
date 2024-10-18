def call(String ImageName, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'docker_hub_cred', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
      sh "docker login -u ${env.USER} -p ${env.PASS}"
  }
  sh "docker push ${env.USER}/${ImageName}:${ImageTag}"
}
