 def gv = load "external-script.groovy"

pipeline {
  agent any
  tools {
    maven 'maven3'
  }
  parameters {
    choice(name: "VERSION", choices: ['1.0', '1.1', '1.2'], description: "")
    booleanParam(name: "executeTests", defaultValue: true, description: "")
  }
  stages {
    stage ('Build') {
      when {
        expression {
          params.VERSION == '1.0'
        }
      }
      steps {
        script {
        gv.buildApp()
      }
      } 
    }
    stage ('Test') {
      steps {
        script {
          gv.testApp
        }
      }
    }
    stage ('deploy') {
      steps {
        script {
          gv.deployApp
        }
      }
    }
  }
}