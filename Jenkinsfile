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
      when {
        expression {
          BRANCH_NAME == 'jenkins-pipeline'
        }
      }
      steps {
        echo 'Building docker image'
        //sh 'docker build -t kelzceana/demo-app:1.1 .'
      }
    }
    stage ('UPLOAD IMAGE') {
      steps {
        echo 'deploying image'
      }
    }
  }
}