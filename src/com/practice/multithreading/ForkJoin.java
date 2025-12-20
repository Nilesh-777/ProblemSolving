package com.practice.multithreading;

import java.util.Date;
import java.util.concurrent.RecursiveTask;

import javax.swing.text.TabStop;

/**
 * Use fork & join to sum 2 halves each taking 3 sec. The resultant sum should
 * get printed in 3 sec
 */
public class ForkJoin {

	public static void main(String[] args) {
		{
			long startTimeMillis = new Date().getTime();

			// Normal Flow
			int sum1 = sum(new int[] { 1, 2, 3 });
			int sum2 = sum(new int[] { 1, 2, 3 });

			int sum = sum1 + sum2;
			System.out.println("Total Sum: " + sum);
			System.out.println("Time taken: " + (new Date().getTime() - startTimeMillis) / 1000 + "s");
		}

		{
			long startTimeMillis = new Date().getTime();

			// Normal Flow
			final SummerTask sum1 = new SummerTask(new int[] { 1, 2, 3 });
			final SummerTask sum2 = new SummerTask(new int[] { 1, 2, 3 });

			sum1.fork();
			sum2.fork();

			int sum = sum1.join() + sum2.join();
			System.out.println("Total Sum: " + sum);
			System.out.println("Time taken: " + (new Date().getTime() - startTimeMillis) / 1000 + "s");
		}

	}

	public static int sum(final int[] arr) {
		int sum = 0;

		for (int i : arr) {
			sum += i;
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return sum;
	}

	public static class SummerTask extends RecursiveTask<Integer> {

		private int[] arr;

		public SummerTask(final int[] arr) {
			this.arr = arr;
		}

		@Override
		protected Integer compute() {
			return ForkJoin.sum(this.arr);
		}

	}

}
