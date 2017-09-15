(ns)

(read-string "(+ 1 2 #_(* 2 2) 8)")

(when true
  (println "test"))

(first "fabcd")

(str "aa" "bb")

(subs "abcd" 1)

(def vowel? (set "aeiou"))

(defn pig-latin [word]
  ; word is expected to be a string
  ; which can be treated like a sequence of characters.
  (let [first-letter (first word)] ; assigns a local binding
    (if (vowel? first-letter)
      (str word "ay")
      (str (subs word 1) first-letter "ay"))))

(println (pig-latin "rced"))

(println (pig-latin "orange"))

(let [aaa (fitst "bdaaaa")])

(source +)

(= [1 2 3] [1, 2, 3])

(def x 1)

(def x "another")

*ns*

(defn average
  [n]
  (/ (apply + n) (count n)))

(average [1 2 3 4 5 6])

(defn another
  [n]
  (/ (apply + n) (count n)))

(another [1 2 3 4 4])

(quote x)

(symbol? (quote x))

'@x

'#(+ % 2)

(do
  (println "hi")
  (apply * [4 5 6]))

(def ^:dynamic v 1)

(defn f1 []
  (println "f1: v =" v))

(defn f2 []
  (println "f2: before let v =" v)
  (let [v 2]
    (println "f2: in let, v = " v)
    (f1))
  (println "f2: after let v = " v))

(defn f3 []
  (println "f3: before binding v =" v)
  (binding [v 3]
    (println "f3: in binding, v =" v)
    (f1))
  (println "f3: after binding v =" v))

(defn f4 []
  (def v 4))

(let [a (inc (rand-int 6))
      b (inc (rand-int 6))]
  (println (format "%s %s" a b))
  (+ a b))
