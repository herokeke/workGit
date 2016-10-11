package gofmodel.TemplateMethod;

/**
 * 任务
 * @author Administrator
 *
 */
public class TaskMagaer extends ExtendFunction {

	@Override
	public void beginOpen() {
		System.out.println("打开工单");

	}

	@Override
	public void commitPhase1() {
		System.out.println("单提交时，提交第一阶段，任务未提交，工单没有流转，表单字段没有保存，执行的逻辑");

	}

	@Override
	public void commitPhase2() {
		System.out.println("工单提交时，提交第二阶段，任务提交，工单流转完完毕，表单字段没有保存，执行的逻辑");

	}

	@Override
	public void commitPhase3() {
		System.out.println("工单提交时，提交第三阶段，任务提交，工单流转完完毕，表单字段保存完成，执行的逻辑");

	}

	@Override
	public void endOpen() {
		System.out.println("关闭工单");

	}

}
