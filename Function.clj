(defn f1 [x y]
    (* x y))

(println (f1 2 3))

(f1 3 8)

(def f2 (fn [x y]
         (+ x y)))

(f2 3 5)

(print (f2 3 8))

(+ 1 2)

(defn f3 [name]
  (str "Hello~!" name))

(f3 "igoist")


(defn greet  [name]  (str "Hello, " name))
(greet "students")


(defn f4 [name]
  (str "F4~!" name))

(f4 "test!!")
