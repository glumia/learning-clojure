;; Brave Clojure
;; Chapter 7 - Clojure Alchemy: Reading, Evaluation, and Macros

;; Create an infix function that takes a list like (1 + 3 * 4 - 5) and
;; transforms it into the lists that Clojure needs in order to correctly
;; evaluate the expression using operator precedence rules.


(defn infix
  "Convert a list of a flat arithmetic expression in infix notation to
  a list that can be evaluated."
  [l]
  (let [x (first l)
        f (second l)
        y (nth l 2)
        g (nth l 3 nil)
        z (nth l 4 nil)
        oth (drop 5 l)]
    (if g
      (if (or (= g /) (= g *))
        (recur (into [x f (list g y z)] oth))
        (recur (into [(list f x y) g z] oth)))
      (list f x y))))

(eval (infix (list 1 + 3 * 3 + 1 * 10 + 100 * 2)))
