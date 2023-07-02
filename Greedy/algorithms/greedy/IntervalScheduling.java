package algorithms.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import algorithms.greedy.models.Job;
import algorithms.util.TimeUtil;

public class IntervalScheduling {

	public static void main(String[] args) {

		List<Job> jobs = new ArrayList<>();
		jobs.add(new Job("A", TimeUtil.getDate(2022, 9, 5, 10, 0, 0), TimeUtil.getDate(2022, 9, 5, 23, 0, 0)));
		jobs.add(new Job("B", TimeUtil.getDate(2022, 9, 5, 11, 0, 0), TimeUtil.getDate(2022, 9, 5, 11, 30, 0)));
		jobs.add(new Job("C", TimeUtil.getDate(2022, 9, 5, 12, 0, 0), TimeUtil.getDate(2022, 9, 5, 15, 0, 0)));
		jobs.add(new Job("D", TimeUtil.getDate(2022, 9, 5, 12, 0, 0), TimeUtil.getDate(2022, 9, 5, 12, 45, 0)));
		jobs.add(new Job("E", TimeUtil.getDate(2022, 9, 5, 12, 30, 0), TimeUtil.getDate(2022, 9, 5, 12, 44, 59)));
		jobs.add(new Job("F", TimeUtil.getDate(2022, 9, 5, 14, 0, 0), TimeUtil.getDate(2022, 9, 5, 15, 0, 0)));
		jobs.add(new Job("G", TimeUtil.getDate(2022, 9, 5, 14, 1, 0), TimeUtil.getDate(2022, 9, 5, 14, 30, 0)));
		jobs.add(new Job("H", TimeUtil.getDate(2022, 9, 5, 18, 0, 0), TimeUtil.getDate(2022, 9, 5, 19, 0, 0)));
		jobs.add(new Job("I", TimeUtil.getDate(2022, 9, 5, 19, 0, 0), TimeUtil.getDate(2022, 9, 5, 22, 0, 0)));
		jobs.add(new Job("J", TimeUtil.getDate(2022, 9, 5, 16, 0, 0), TimeUtil.getDate(2022, 9, 6, 11, 0, 0)));
		
		List<Job> result = compute(jobs);
		
		for(Job job: result) {
			System.out.println(job);
		}
		
	}

	private static List<Job> compute(List<Job> jobs) {
		jobs = jobs.stream().filter(job -> null != job)
				.sorted(Comparator.comparing(Job::getEndTime, (endTime1, endTime2) -> {
					if (null == endTime1 || null == endTime2)
						return 0;
					return endTime1.compareTo(endTime2);
				})).collect(Collectors.toList());
		
		List<Job> result = new ArrayList<>();
		Date maxEndTime = null;
		
		for(Job job: jobs) {
			if(null!=job && (maxEndTime ==  null || (maxEndTime.compareTo(job.getStartTime()) <= 0))) {
				maxEndTime = job.getEndTime();
				result.add(job);
			} 
		}
		return result;
	}
}
