package algorithms.greedy;

import java.util.ArrayList;
import java.util.List;

import algorithms.greedy.models.Job;
import algorithms.util.TimeUtil;

public class MinimumMaxLatency {

	public static void main(String[] args) {

		List<Job> jobs = new ArrayList<>();
		jobs.add(new Job("A", TimeUtil.getDate(2022, 9, 5, 9, 0, 0), TimeUtil.getDate(2022, 9, 5, 9, 10, 0), TimeUtil.getDate(2022, 9, 5, 3, 0, 0)));
		jobs.add(new Job("B", TimeUtil.getDate(2022, 9, 5, 9, 40, 0), TimeUtil.getDate(2022, 9, 5, 12, 0, 0), TimeUtil.getDate(2022, 9, 5, 3, 0, 0)));
		jobs.add(new Job("C", TimeUtil.getDate(2022, 9, 5, 9, 50, 0), TimeUtil.getDate(2022, 9, 5, 11, 20, 0), TimeUtil.getDate(2022, 9, 5, 3, 0, 0)));
		jobs.add(new Job("D", TimeUtil.getDate(2022, 9, 5, 11, 0, 0), TimeUtil.getDate(2022, 9, 5, 11, 30, 0), TimeUtil.getDate(2022, 9, 5, 3, 0, 0)));
		jobs.add(new Job("E", TimeUtil.getDate(2022, 9, 5, 15, 0, 0), TimeUtil.getDate(2022, 9, 5, 19, 0, 59), TimeUtil.getDate(2022, 9, 5, 3, 0, 0)));
		jobs.add(new Job("F", TimeUtil.getDate(2022, 9, 5, 18, 0, 0), TimeUtil.getDate(2022, 9, 5, 20, 0, 0), TimeUtil.getDate(2022, 9, 5, 3, 0, 0)));

		//int result = compute(jobs);
		//System.out.println(result);
	}
	

}
