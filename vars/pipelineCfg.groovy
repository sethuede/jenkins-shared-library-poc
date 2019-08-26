def call() {
  sh "pwd"
  sh "ls"
  Map pipelineCfg = readYaml(file: "${WORKSPACE}/source-code-poc/develop_pipeline/pipeline.yaml")
  return pipelineCfg
}
