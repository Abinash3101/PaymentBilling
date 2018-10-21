node {
    stage('Configure') {
        env.PATH = "${tool 'maven-3.5.4'}/bin:${env.PATH}"
        version = '1.0.' + env.BUILD_NUMBER
        currentBuild.displayName = version;
    }

    stage('Checkout') {
       git 'https://github.com/Abinash3101/PaymentBilling'
    }

    stage('Version') {
        sh "echo \'\ninfo.build.version=\'$version >> src/main/resources/application.properties || true"
        sh "mvn -B -V -U -e version:set -DnewVersion=$version"
    }

    stage('Build') {
        sh 'mvn -B -V -U -e clean package'
    }

    stage('Archive') {
        junit allowEmptyResults: true, testResults: '**/target/**/TEST*.xml'
    }
}