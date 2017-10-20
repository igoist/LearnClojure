





(loop [a -100]
  (if (< a 100)
    (do
      (println a)
      (recur (+ a 20)))))

(dotimes [a 5]
  (do
    (println a)))





(- (* (rand 1) 1000) 500)
(- (* (rand 1) 1000) 500)

(defn getRandomColor
  []
  (let [r (int (* (rand 1) 255)) g (int (* (rand 1) 255)) b (int (* (rand 1) 255))]
    (do
      (println r g b)
      (println (Integer/parseInt r 16)))))

(getRandomColor)


(defn xx [n]
  (case n
    1 "1"
    2 "2"
    3 "3"
    4 "4"
    5 "5"
    6 "6"
    7 "7"
    8 "8"
    9 "9"
    10 "a"
    11 "b"
    12 "c"
    13 "d"
    14 "e"
    15 "f"))

(xx 15)

(defn t->x [num]
  (println (/ num 16) (rem num 16)))

(t->x 255)
o




; 余数 remainder
(rem 255 16)
(unchecked-remainder-int 255 16)
