pipeline {
  agent any
  tools {
    maven 'maven3'
  }
  stages {
    stage('increment version') {
      steps {
        script {
          echo 'incrementing App version'
          sh 'mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                        versions:commit'
        }
      }

    }
    stage ('Build jar file') {
      steps {
        sh 'mvn package'
      }
    }
    stage ('Build image') {
      steps {
        echo 'Building docker image'
        // get docker hub login credentials
        withCredentials([usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
          sh 'docker build -t kelzceana/demo-app:1.1 .'
          sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
          sh 'docker push kelzceana/demo-app:1.1'
        }
        //sh 'docker build -t kelzceana/demo-app:1.1 .'
      }
    }
    stage ('UPLOAD IMAGE') {
      steps {
        script {
          def dockerCmd 'docker run -p 3000:3080 kelzceana/web-app:1.0'
          sshagent(['EC2-server-key']) {
            // some block
            sh "ssh -o StrictHostKeyChecking=no ec2-user@54.166.104.195 ${dockerCmd}"
          }
        }
        echo 'deploying image....'
              
      }
    }
  }
}