package algorithms.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import algorithms.greedy.models.Job;
import algorithms.util.TimeUtil;

public class IntervalPartitioning {
 
	public static void main(String[] args) {

		List<Job> jobs = new ArrayList<>();
		jobs.add(new Job("A", TimeUtil.getDate(2022, 9, 5, 9, 0, 0), TimeUtil.getDate(2022, 9, 5, 9, 10, 0)));
		jobs.add(new Job("B", TimeUtil.getDate(2022, 9, 5, 9, 40, 0), TimeUtil.getDate(2022, 9, 5, 12, 0, 0)));
		jobs.add(new Job("C", TimeUtil.getDate(2022, 9, 5, 9, 50, 0), TimeUtil.getDate(2022, 9, 5, 11, 20, 0)));
		jobs.add(new Job("D", TimeUtil.getDate(2022, 9, 5, 11, 0, 0), TimeUtil.getDate(2022, 9, 5, 11, 30, 0)));
		jobs.add(new Job("E", TimeUtil.getDate(2022, 9, 5, 15, 0, 0), TimeUtil.getDate(2022, 9, 5, 19, 0, 59)));
		jobs.add(new Job("F", TimeUtil.getDate(2022, 9, 5, 18, 0, 0), TimeUtil.getDate(2022, 9, 5, 20, 0, 0)));

		int result = compute(jobs);
		System.out.println(result);
	}

	private static int compute(List<Job> jobs) {
		jobs = jobs.stream().filter(job -> null != job)
				.sorted(Comparator.comparing(Job::getStartTime, (startTime1, startTime2) -> {
					if (null == startTime1 || null == startTime2)
						return 0;
					return startTime1.compareTo(startTime2);
				})).collect(Collectors.toList());
		Map<Integer, Date> map = new HashMap<Integer, Date>();
		int count = 0;
		for(Job job: jobs) {
			if(null == job) continue;
			if(map.isEmpty()) {
				map.put(++count, job.getEndTime());
			} else {
				boolean isCompatible = false;
				for(Map.Entry<Integer, Date> entry: map.entrySet()) {
					if(entry.getValue().compareTo(job.getStartTime()) <= 0) {
						isCompatible = true;
						map.put(entry.getKey(), job.getEndTime());
						break;
					}
				}
				if(!isCompatible) {
					map.put(++count, job.getEndTime());
				}
			}
		}
		return count;
	}
}
