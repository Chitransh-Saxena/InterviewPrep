package com.DSA.InterviewQuestions;

public class VMware {

    /*
        HLD
        -> Have to optimise the filteration process.
        service UI-> getPrices(SingleResource) -> 	calling azure service -> gets all resources price (we only need one) (takes 30secs)



Ways to improvise
	-> Cache
		-> For regularly used items
		-> Risk of thrashing is here
	-> DB
		->
	-> File
		-> On Disk
		-> Refresh this on separate service (crontab scheduled)
			-> Risk of File Descriptor Lock



DS
	-> setAll(

	)
		-> One val sets vals for all the keys
		-> all the key's values should change to 500, after setAll(500)
	-> setVal(key, val)
		-> 1,100
		-> 2,200
		-> 3,300
	-> getVal(key)
		-> return 100 for 1


	Solution 1 - BF

	class MyMap {

		private Map<Integer, Integer> map = new HashMap<>();

		boolean flag updated = false;
		Integer value = Integer.MIN;

		public Integer getVal(Integer key) {

			if(updated) {

				map.add(key, value);
				// return value;

			}


			if(map.contains(key)) {
			return map.get(key);

			}

			return 0
		}

		public void setVal(Integer key, Integer val) {

			map.add(key, val);
		}

		public void setAll(Integer val) {

			updated = true;
			value = val;


			for(Integer map.getEntrySet x: map) {
				setVal(x, val);
			}
		}

	}

	-> How to figure out what is the way to set all values to some certain value in one go.
		->

	-> static vs dynamic class



     */
}
