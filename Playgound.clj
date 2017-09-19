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

(for i in (rand-int 6)
  (let [test 2]
    (println test)))

(let [location (get-lat-long)
      _ (println "Current: " location)
      location (find-city-name location)])

(def v [42 "foo" 99.2 [5 12]])

(first v)

(second v)

(last v)

(nth v 1)

(v 2)

(.get v 3)

(+ (first v) (v 2))

(+ (first v) (first (last v)))

(let [[x y z d] v]
     (println x "-" y "-" z "-" d))

(let [[x _ _ [y z]] v]
     (println x "-" y "-" z))

(let [[x & rest] v]
  rest)

(let [[x _ z :as original-vector] v]
  (println v)
  (println original-vector)
  (conj original-vector (+ x z)))

(def m {:a 5 :b 6
        :c [7 8 9]
        :d {:e 10 :f 11}
        ;:aa 11
        "foo" 88
        42 false})

(let [{a :a b :b c :c d :d f "foo" e 42} m]
  (print a b c d f e))

(let [{x 1 y 3} [0 1 2 3 4 5 6 7 8 9]]
  (println (+ x y)))

(let [{x 0 y 2} "abcdef"]
  (println x y))

(let [{{e :e} :d} m]
  (* 2 e))

(let [{x :d} m]
  (let [{e :e} x]
    (* 2 e)))

(let [{r1 :x r2 :y :as randoms}
      (zipmap [:x :y :z] (repeatedly (partial rand-int 10)))]
  (assoc randoms :sum (+ r1 r2)))

(let [{k :unknown aa :aa x :a
       :or {k 50 aa 30}} m]
  (+ k x aa))

(let [{opt1 :option} {:option false}
      opt1 (or opt1 123)
      {opt2 :option :or {opt2 true}} {:option false}]
  {:opt1 opt1 :opt2 opt2})

(let [{aa :abc} {:abc 123}]
  (println aa))

(def chris {'name "Chris" 'age 33 'location "ABCP"})

(let [{:syms [name age location]} chris]
  (format "%s is %s years old and lives in %s." name age location))

(def user-info [ "rob999" 2017 :name "T" :city "B"])

(let [{a 0 b 1 c 2 d 3} user-info]
  (println a b c d))

(let [[username account-year & extra-info] user-info
      {:keys [name city]} (apply hash-map extra-info)]
  (format "%s, %s" name city))

(let [[un ay & {:keys [name city]}] user-info]
  (format "%s, %s" name city))

((fn [x] (* 10 x)) 10)

(let [x ((fn [a] (+ 1 a)) 2)]
    (println x))

(defn sss
  ([x] (println (+ x)))
  ([x y] (println(+ x y))))

(sss 1)

(sss 1 2)

(def sta (fn sss
           ([y] (sss y))
           ([y z] (sss y z))))

(sta 1 2)
; error! StackOverflowError 因为这个 sss 并不是前面定义的 sss 引用，而是自身别名

(def sta2 (fn adder-self-reference
           ([y] (adder-self-reference y 1))
           ([y z] (+ y z))))

(sta2 1 3)

(letfn [(odd? [n]
          (even? (dec n)))
        (even? [n]
          (or (zero? n)
              (odd? (dec n))))]
  (odd? 11))

(defn concat-rest
  [x & rest]
  (apply str (butlast rest)))

(concat-rest 1 2 3 4 5)

(defn make-user
  [& [user-id a]]
  (println user-id a)
  {:user-id (or user-id
                (str (java.util.UUID/randomUUID)))})

(make-user)

(make-user "aaa" "bbb")

(make-user "aaa" "bbb" :user-id "ccc")

(defn make-user2
  [username & {:keys [email join-date]
               :or {join-date (java.util.Date.)}}]
  {:username username
   :join-date join-date
   :email email
   :exp-date (java.util.Date. (long ( + 2.592e9 (.getTime join-date))))})

(make-user2 "Boddy")

(make-user2 "Boddy"
            :join-date (java.util.Date. 111 0 1)
            :email "boddy@2.com")

(def tt (#(do
            (println "sss")
            (Math/pow %1 %2)) 2 4))

; if | conditional
(if "hi" \t)

(if 111 \t)

(if nil "aa" "bb")

(if false "aa" "bb")

(if (not true) "aa" "bb")

(if (not true) "aa")

(if true
  (do
    (println "aa")
    (println "ax"))
  (println "bb"))

(loop [x 5]
  (if (neg? x)
    x
    (recur (dec x))))

(def xx 123)

(conj (sorted-set) "D" "C" "S" "A")

(def score {"A" 100})

(assoc score "A" 911)

(dissoc score "AA")

(defn print-name []
  (println "Hello, " name)
  (let [name "Bob"]))
(print-name)

(def sss (* (* 1.4 (Math/pow 6000 3)) (Math/pow 100000 3)))

(* (Math/pow (/ (* 82 (* 1.5 (Math/pow 10 8))) 6000) 3) sss)
