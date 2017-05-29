pipeline {
	agent any

	tools {
		maven 'apache-maven-latest'
	}
	
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