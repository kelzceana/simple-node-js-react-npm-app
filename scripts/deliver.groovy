def execute() {
    sh './jenkins/scripts/deliver.sh'
    input message: 'Finished using the web site? (Click "Proceed" to continue)'
    sh './jenkins/scripts/kill.sh'
}
return this