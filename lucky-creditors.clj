;; Problem: you have some creditors to whom you owe money but your budget is
;; limited. You can't pay them all back but you could at least estinguish your
;; debt with some of them. Write a function that helps you to pick this subset
;; of lucky creditors.



(def creditors [{:name "Tim" :amount 12}
                {:name "Bob" :amount 15}
                {:name "Martin" :amount 42}
                {:name "Edsger" :amount 17}
                {:name "Guido" :amount 1}])

(def budget 70)

(defn lucky-creditors
  "Given a list of creditors and a budget returns the list of creditors we are
  able to pay."
  [creditors budget]
  (take-while #(< (:amount %) budget)
              (reduce
               (fn [processed-creditors creditor]
                 (conj processed-creditors
                       (update-in creditor
                                  [:amount]
                                  +
                                  (:amount (last processed-creditors)))))
               [(first creditors)]
               (rest creditors))))

(lucky-creditors creditors budget)

