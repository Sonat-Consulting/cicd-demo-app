node {

    stage 'Checkout git'
    git branch: 'master', url: 'https://github.com/Sonat-Consulting/cicd-demo-app.git'

    stage 'Jar'
    docker.image('maven').inside() {
            sh 'mvn package spring-boot:repackage -DskipTests=true'
    }

    stage 'Docker'
    docker.image('docker').inside() {
        sh 'docker build --build-arg ARTIFACT=/target/demo-0.0.1-SNAPSHOT.jar -t localhost:5000/demo .'
    }

    stage 'IT'
    docker.image('docker/compose:1.21.1').inside('-v /var/run/docker.sock:/var/run/docker.sock') {
        sh 'docker-compose -f docker/docker-compose-jenkins.yml up -d'
        def ip = "\$(docker inspect --format '{{ .NetworkSettings.Networks.jenkinsdockertest_jdt.Gateway }}' demo)"
        sleep 15
        sh "curl -# http://${ip}:8888/actuator/health"
        sh 'docker-compose down'
    }

}
