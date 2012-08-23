(ns PokerHands.core-test
  (:use clojure.test
        PokerHands.core))


; (defn gen-royal-flush-hand []
; 	[])

; (deftest a-test
; 	(let [royal-hand (gen-royal-flush-hand)]
  		
;     		(is (= (is-royal-flush royal-hand) 
;     			(and 
;     				(is-flush royal-hand)
;     				(is-straight royal-hand)
;     				(has-high-card :A royal-hand))))))


(deftest not-flush-when-two-suits 
	(is (not (is-flush [{:rank 2 :suit :H} {:rank 2 :suit :S}]))))

(deftest flush-when-same-suit 
	(is (is-flush [{:rank 2 :suit :S} {:rank 2 :suit :S}])))

; (deftest its-a-straight
; 	(is (is-straight [{:rank 2} {:rank 4} {:rank 3}])))

;(deftest non-consecutive-cards-not-a-straight
;	(is (not (is-straight [{:rank 2} {:rank 4} {:rank 6}]))))

(deftest all-different-test
	(is (all-different-ranks 
			[{:rank 3 :suit :S} {:rank 2 :suit :S}])))

(deftest numbers-are-consecutive-integers-test
	(is (consecutive? [1 2]))
	(is (not (consecutive? [1 3])))
	(is (not (consecutive? [3 1])))
	(is (not (consecutive? [5 4 1]))))

(deftest numbers-arent-consecutive-integers-test
	(is (not (consecutive? [1 3 2]))))

; (deftest numbers-are-unsorted-consecutive-test  
; 	(is (numbers-are-unsorted-consecutive [1 4 3 2])))

(deftest ranks-test
	(is (= [4 3 2] (ranks [{:rank 3} {:rank 2} {:rank 4}]))))
