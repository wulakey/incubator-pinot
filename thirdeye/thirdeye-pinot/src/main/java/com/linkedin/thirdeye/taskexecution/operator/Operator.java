package com.linkedin.thirdeye.taskexecution.operator;

import com.linkedin.thirdeye.taskexecution.dag.NodeIdentifier;

public interface Operator {

  void setNodeIdentifier(NodeIdentifier nodeIdentifier);

  void initialize(OperatorConfig operatorConfig);

  void run(OperatorContext operatorContext);
}