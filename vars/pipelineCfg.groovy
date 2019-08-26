def call() {
  sh "pwd"
  sh "ls"
  Map pipelineCfg = readYaml(file: "/var/lib/jenkins/workspace/source-code-poc/develop_pipeline/pipeline.yaml")
  return pipelineCfg
}
