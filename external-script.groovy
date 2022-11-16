def buildApp() {
  echo 'This is the build phase'
}

def testApp() {
  echo 'This is the test phase'
}

def deployApp(txt) {
  echo "This is the deployment phase to ${txt} env "
}

return this