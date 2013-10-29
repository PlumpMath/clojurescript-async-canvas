; async-canvas
;; draw shapes on canvas of various colors and position depending on their timeout

(ns async-canvas.core
  (:refer-clojure :exclude [map])
  (:require [cljs.core.async :as async
             :refer [<! >! chan put! timeout]]
            [clojure.string :as string])
  (:require-macros [cljs.core.async.macros :refer [go alt!]]))


;; create channel
(def c (chan))

;; create canvas dimension properties
(def canvas_width 1000)
(def canvas_height 1000)

;; create canvas DOM element
(def canvas
  (.createElement js/document "canvas"))

;; set canvas properties
(set! (. canvas -width) canvas_width)
(set! (. canvas -height) canvas_height)

;; get body element
(def body
  (.getElementById js/document "body"))
  
;; append canvas to body
(.appendChild body canvas)


(defn draw_items_in_canvas [n]
  (let [context (.getContext canvas "2d")
        xpos (* canvas_width (rand))
        ypos (* canvas_height (rand))
        color (cond
               (= n 1) "#ffcccc"
               (= n 2) "#ccffcc"
               :else "#ccccff")]
    (do
      (set! (. context -fillStyle) color)
      (.fillRect context xpos ypos 10 10))))


(go (while true (<! (timeout 25)) (>! c 1)))
(go (while true (<! (timeout 100)) (>! c 2)))
(go (while true (<! (timeout 150)) (>! c 3)))

(go (while true (draw_items_in_canvas (<! c))))


;; PEEK-A-BOO!
(. js/console (log "Peek-a-boo! I see you!"))