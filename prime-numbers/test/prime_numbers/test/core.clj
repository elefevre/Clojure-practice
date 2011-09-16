(ns prime-numbers.test.core
  (:use [clojure.test])
  (:use midje.sweet)
 )

(defn primes-after[smaller-primes from]
	(cond
		(every? (fn[n] (pos? (mod from n))) smaller-primes) from
		:else (primes-after smaller-primes (inc from))
	)
)
(defn primes[n] 
	(cond
		(= n 1) [2]
		(= n 2) [2 3]
		:else 
			(let [smaller-primes (primes (dec n))
				next-candidate (inc (inc (last smaller-primes)))] 
				(concat smaller-primes [(primes-after smaller-primes next-candidate)]))
	)
)

(fact (primes 1) => [2])
(fact (primes 2) => [2 3])
(fact (primes 3) => [2 3 5])
(fact (primes 4) => [2 3 5 7])
(fact (last (primes 100)) => 541)
