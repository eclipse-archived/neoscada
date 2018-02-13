pipeline {
	agent any
	
	environment {
	    CI = 'JENKINS'
	}


	tools {
		maven 'apache-maven-latest'
	}
	
	stages {
		stage('Build') {
			steps {
				sh "rm -rf ~/.m2/repository/org/eclipse/scada"
				sh "rm -rf ~/.m2/repository/org/eclipse/neoscada"
				sh 'MAVEN_OPTS="-Xms1024m -Xmx3072m" mvn -Dmaven.test.failure.ignore=true -Dmaven.test.skip=true -T 4 clean install'
			}
		}
		stage('Archive') {
			steps {
				archive '**/*-p2/target/*p2-*.zip'
				archive '**/*-product/target/products/*.tar.gz'
				archive '**/*-product/target/products/*.zip'
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