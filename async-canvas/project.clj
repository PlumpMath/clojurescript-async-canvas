(defproject async-canvas "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
	:repositories {"sonatype-staging"
                 "https://oss.sonatype.org/content/groups/staging/"}
	
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1978"]
                 [org.clojure/core.async "0.1.242.0-44b1e3-alpha"]]

  :plugins [[lein-cljsbuild "0.3.4"]]

  :source-paths ["src"]

  :cljsbuild { 
    :builds [{:id "async-canvas"
              :source-paths ["src"]
              :compiler {
                :output-to "async_canvas.js"
                :output-dir "out"
                :optimizations :none
                :source-map true}}]})

