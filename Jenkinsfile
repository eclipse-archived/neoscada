pipeline {
	agent any

	tools {
		maven 'apache-maven-latest'
	}
	
	stages {
		stage('Build') {
			steps {
				sh 'mvn -Dmaven.test.failure.ignore=true clean install'
			}
		}
		stage('Archive') {
			steps {
				archive '**/*-p2/target/*p2-*.zip'
				archive '**/*-p2/target/*p2-*.deb'
				archive '**/*-p2/target/*p2-*.rpm'
			}
		}
		stage('Deploy') {
			steps {
				echo 'Deploying....'
			}
		}
	}
}