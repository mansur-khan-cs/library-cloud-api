pipeline {

	agent any
	environment {
		PROJECT_ID = 'my-k8s-project-300415'
		CLUSTER_NAME = 'library-cloud-api-k8-cluster'
		LOCATION = 'europe-west1'
		CREDENTIALS_ID = 'my-k8s-project'
	}
	
	stages {
		stage ('Scm Checkout') {
			steps {				
				checkout([$class: 'GitSCM', branches: [[name: '*/*']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/zahirulislam04/library-cloud-api.git']]])
			}
		}
		
		stage ('Build') {
			steps {
				echo "Cleaning and building jar file"
				echo $M2_HOME
				echo $PATH
				sh 'mvn clean install'
				
			}				
		}
		
		stage ('Test') {
			steps {
				echo  "Testing.."
				sh 'mvn test'
			}
		}
		
		stage ('Build Docker Image') {
			steps {
				sh 'whoami'
				script {
					myimage = docker.build("zahirulislam/library-cloud-api:${env.BUILD_ID}")					
				}
			}
		}
		
		
	}
}