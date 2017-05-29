pipeline {
	agent any

	stages {
		stage('Build') {
			steps {
				sh "mvn clean install"
			}
		}
		stage('Deploy') {
			steps {
				echo 'Deploying....'
			}
		}
	}
}