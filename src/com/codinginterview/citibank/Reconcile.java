package com.codinginterview.citibank;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sridhar
 * 
 * 	Input values might be empty but it should always return a Stream.
 * 
 *  A  "pendingTransaction" is considered "processed" if 
 * 
 *  	1) a corresponding object is found in Stream<Stream<ProcessedTransaction>>
 *    	2) the corresponding object has the same ID, but the type of pendingTransaction id is Long 
 *    	 where has the type of ProcessedTransaction Id is string and it might be null or empty. 
 *    	 Luckily if it has a value it will certainly be a numeric value.
 *    	3) Status of the transaction should be "DONE" case insensitive
 *
 */
class Reconcile {

	Stream<PendingTransaction> reconcile(Stream<PendingTransaction> pending,
			Stream<Stream<ProcessedTransaction>> processed) {
		if (pending == null || processed == null)
			return Stream.empty();

		List<ProcessedTransaction> processedList = Optional.of(processed).orElseGet(() -> Stream.empty())
				.filter(Objects::nonNull).flatMap(Function.identity()).filter(Objects::nonNull)
				.collect(Collectors.toList());
		List<PendingTransaction> pendingList = Optional.of(pending).orElseGet(() -> Stream.empty())
				.filter(Objects::nonNull).collect(Collectors.toList());

		return pendingList.stream().filter(p -> isPending(p, processedList)).collect(Collectors.toList()).stream();
	}

	private boolean isPending(PendingTransaction p, List<ProcessedTransaction> processedList) {
		String pendingId = (p.getId() == null) ? String.valueOf(0L) : String.valueOf(p.getId());
			for(ProcessedTransaction processed : processedList) {
				String processedTransactionId= processed.getId() == null ? "" :  processed.getId().trim();
				String processedTransactionStatus = processed.getStatus() == null ? "" : processed.getStatus();
				if(processedTransactionId.equals(pendingId))
					if("done".equalsIgnoreCase(processedTransactionStatus)) {
						return false;
					}				
			}		
		 return true;
	}

	public static void main(String[] args) {
		
	}
}
