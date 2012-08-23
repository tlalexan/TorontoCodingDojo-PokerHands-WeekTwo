(ns PokerHands.core)

(defn is-flush [hand]
	(= 1 (count (set (map :suit hand)))))

(defn all-different-ranks [hand]
	(= (count (set (map :rank hand))) (count hand)))

(defn is-straight [hand]
	(let [sorted-hand (sort > (map :rank hand))
		  range1 (- (last sorted-hand) (first sorted-hand))
		 ]
		  (and (all-different-ranks hand) (= range1 (count hand)))))

(defn has-high-card [card hand] true)

(defn is-royal-flush [hand] true)

(defn consecutive? [numbers]
	(let [sorted (sort numbers)]
	 (and (= numbers sorted)
;	      (= 1 (- (first sorted) (second sorted))  )
	      (= (range (first sorted) (+ (last sorted) 1)) sorted))))

(defn ranks [cards]
	(sort > (map :rank cards)))