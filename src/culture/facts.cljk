(ns culture.facts
  "Regional-culture catalog for Lyon (Ville de Lyon) -- local dishes,
  protected products, beverages, festivals and heritage sites, piggybacked
  onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"lyon"
   [{:culture/id "lyon.dish.quenelle"
     :culture/name "Quenelle"
     :culture/name-local "Quenelle de brochet"
     :culture/municipality "lyon"
     :culture/country "FRA"
     :culture/kind :dish
     :culture/summary "Mixture of creamed fish or meat formed into an egg-like shape; pike quenelles (quenelles de brochet) are a regional specialty of Lyon, often served with crayfish sauce."
     :culture/url "https://en.wikipedia.org/wiki/Quenelle"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "lyon.dish.salade-lyonnaise"
     :culture/name "Salade lyonnaise"
     :culture/municipality "lyon"
     :culture/country "FRA"
     :culture/kind :dish
     :culture/summary "Traditional composed salad of Lyonnaise cuisine combining greens, bacon, croutons and a poached egg."
     :culture/url "https://fr.wikipedia.org/wiki/Salade_lyonnaise"
     :culture/url-provenance :wikipedia-fr
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "lyon.dish.cervelle-de-canut"
     :culture/name "Cervelle de canut"
     :culture/municipality "lyon"
     :culture/country "FRA"
     :culture/kind :dish
     :culture/summary "Cheese spread or dip of seasoned fromage blanc, a specialty of Lyon; its name ('silk worker's brain') references the city's 19th-century weavers."
     :culture/url "https://en.wikipedia.org/wiki/Cervelle_de_canut"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "lyon.dish.tablier-de-sapeur"
     :culture/name "Tablier de sapeur"
     :culture/municipality "lyon"
     :culture/country "FRA"
     :culture/kind :dish
     :culture/summary "Lyonnais specialty dish made from beef tripe, one of the most common dishes served in the bouchons of Lyon."
     :culture/url "https://en.wikipedia.org/wiki/Tablier_de_sapeur"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "lyon.product.rosette-de-lyon"
     :culture/name "Rosette de Lyon"
     :culture/municipality "lyon"
     :culture/country "FRA"
     :culture/kind :product
     :culture/summary "Cured pork saucisson from France, usually served thinly sliced, associated with Lyon and its cuisine."
     :culture/url "https://en.wikipedia.org/wiki/Rosette_de_Lyon"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "lyon.product.coussin-de-lyon"
     :culture/name "Coussin de Lyon"
     :culture/municipality "lyon"
     :culture/country "FRA"
     :culture/kind :product
     :culture/summary "Sweet specialty of Lyon composed of chocolate and marzipan, created by the Voisin chocolatier and inspired by a silk cushion from a 1643 plague procession to the Fourvière basilica."
     :culture/url "https://en.wikipedia.org/wiki/Coussin_de_Lyon"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "lyon.beverage.beaujolais"
     :culture/name "Beaujolais"
     :culture/municipality "lyon"
     :culture/country "FRA"
     :culture/kind :beverage
     :culture/summary "Wine from the Beaujolais region, historically confined mostly to the markets along the Saône and Rhône, particularly the city of Lyon."
     :culture/url "https://en.wikipedia.org/wiki/Beaujolais"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "lyon.craft.canut-silk-weaving"
     :culture/name "Canut silk weaving"
     :culture/name-local "Canuts"
     :culture/municipality "lyon"
     :culture/country "FRA"
     :culture/kind :craft
     :culture/summary "The canuts were Lyonnais silk workers, often working on Jacquard looms, centred in Lyon's Croix-Rousse neighbourhood during the 19th century."
     :culture/url "https://en.wikipedia.org/wiki/Canut"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "lyon.festival.fete-des-lumieres"
     :culture/name "Festival of Lights"
     :culture/name-local "Fête des Lumières"
     :culture/municipality "lyon"
     :culture/country "FRA"
     :culture/kind :festival
     :culture/summary "Popular event in Lyon originally expressing gratitude toward Mary, held annually around 8 December for about four days."
     :culture/url "https://en.wikipedia.org/wiki/Festival_of_Lights_(Lyon)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "lyon.heritage.historic-site-of-lyon"
     :culture/name "Historic Site of Lyon"
     :culture/municipality "lyon"
     :culture/country "FRA"
     :culture/kind :heritage
     :culture/summary "The districts of Old Lyon, the Fourvière hill, the Presqu'île and the slopes of the Croix-Rousse are inscribed on the UNESCO World Heritage List."
     :culture/url "https://en.wikipedia.org/wiki/Historic_Site_of_Lyon"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-fra-lyon culture catalog "
                 "(ADR-2607171400): " (count (get catalog "lyon"))
                 " Lyon entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
