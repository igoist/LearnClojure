; *1 (the last result)
; *2 (the result two expressions ago)
; *3 (the result three expressions ago)
(+ 3 4)   ; 7
(+ 10 *1) ; (+ 10 7) => 17
(+ *1 *2) ; (+ 17 7) => 24
(+ *1 *2 *3) ; 48