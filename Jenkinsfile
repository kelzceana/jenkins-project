pipeline {
  agent any
  tools {
    maven 'maven3'
  }
  stages {
    stage ('Build jar file') {
      steps {
        sh 'mvn package'
      }
    }
    stage ('Build image') {
      steps {
        echo 'Building docker image'
        // get docker hub login credentials
        withCredentials([usernamePassword(credentialsID: 'docker-hub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
          sh 'docker build -t kelzceana/demo-app:1.1 .'
          sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
          sh 'docker push kelzceana/demo-app:1.1'
        }
        //sh 'docker build -t kelzceana/demo-app:1.1 .'
      }
    }
    stage ('UPLOAD IMAGE') {
      steps {
        
      }
    }
  }
}