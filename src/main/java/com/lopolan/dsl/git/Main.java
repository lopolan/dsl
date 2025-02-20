package com.lopolan.dsl.git;

import java.io.File;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

/**
 * <h1> Main</h1>
 *
 * <pre>
 *
 * </pre>
 *
 * @author lopo
 * @date 2021/12/9 2:04 下午
 **/
public class Main {

  public static void main(String[] args) {
    try {
      Git git = Git.cloneRepository()
          .setURI("http://git.hxyc.smarte.tech:50000/cloud_core/common-logger.git")
          .setCredentialsProvider(new UsernamePasswordCredentialsProvider("test","12345678"))
          .setBranch("master")
          .setDirectory(new File("/tmp/common-logger")).call();
    } catch (GitAPIException e) {
      e.printStackTrace();
    }
  }
}
