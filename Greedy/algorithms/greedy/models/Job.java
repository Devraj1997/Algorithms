package algorithms.greedy.models;

import java.util.Date;

public class Job {

	private String name;
	private Date startTime;
	private Date endTime;
	private Date deadline;

	public Job() {
		super();
	}

	public Job(String name, Date startTime, Date endTime) {
		super();
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Job(String name, Date startTime, Date endTime, Date deadline) {
		super();
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.deadline = deadline;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	@Override
	public String toString() {
		return "Job [name=" + name + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}
