def call() {
  node {
    
    def test = JOB_NAME
    def (name, value) = test.split("/")
    def (areho1, areho2) = value.split("_")
    def maha = areho1.replaceFirst('-','/')
     
       checkout([$class: 'GitSCM',
                 branches: [[name: "*/${maha}"]],
        doGenerateSubmoduleConfigurations: false,
        extensions: [],
        submoduleCfg: [],
        userRemoteConfigs: [[
            
          url: "https://github.com/durgaprasad444/${name}.git"
             ]]])
    def p = pipelineCfg()
         sh """
         cd /var/lib/jenkins/workspace/${JOB_NAME}/
         ls
         echo ${name}
         echo ${maha}
         """
         sh "echo ${p.branch}"
         sh "echo ${p.test}"
        
  }
}
