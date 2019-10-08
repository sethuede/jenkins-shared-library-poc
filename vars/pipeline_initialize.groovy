def call() {
  node {
    def test = JOB_NAME
    def (name, value) = test.split("/")
    def (var1, var2) = value.split("_")
    def var3 = var1.replaceFirst('-','/')
       checkout([$class: 'GitSCM',
                 branches: [[name: "*/${var3}"]],
        doGenerateSubmoduleConfigurations: false,
        extensions: [],
        submoduleCfg: [],
        userRemoteConfigs: [[
            credentialsId: 'git_cred', 
          url: "https://github.com/durgaprasad444/${name}.git"
             ]]])
   
   
   def p = pipelineCfg()

   switch(p.pipelineType) {
      case 'python':
        // Instantiate and execute a Python pipeline
            mine()
   }
   switch(p.pipelineType) {
      case 'pythonexample':
        // Instantiate and execute a Python pipeline
            pythonexample()
   }
   switch(p.pipelineType) {
      case 'mavenexample':
        // Instantiate and execute a Python pipeline
            mavenexample()
   }
   switch(p.pipelineType) {
      case 'nodeexample':
        // Instantiate and execute a Python pipeline
            nodeexample()
   }
   switch(p.pipelineType) {
      case 'dotnetexample':
        // Instantiate and execute a Python pipeline
            dotnetexample()
   }
   switch(p.pipelineType) {
      case 'maven':
        // Instantiate and execute a Python pipeline
            test()
    
   }
   }
}
