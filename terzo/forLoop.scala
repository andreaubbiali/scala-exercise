println("primo")
val dogBreeds = List("Doberman", "Yorkshire Terrier", "Dachshund",
                    "Scottish Terrier", "Great Dane", "Portuguese Water Dog")

for (breed <- dogBreeds)
    println(breed)

println("\nsecondo")
// puoi anche filtrare direttamente nel for
for (breed <- dogBreeds
    if breed.contains("Terrier");
    if !breed.startsWith("Yorkshire")
) println(breed)

println("\nterzo")
// creai una nuova lista con all'interno quei valori
val filteredBreeds = for {
    breed <- dogBreeds
    if breed.contains("Terrier")
    if !breed.startsWith("Yorkshire")
} yield breed
println(filteredBreeds)

println("\nquarto")
// creazione di una variabile internamente che ha scope anche fuori
for {
    breed <- dogBreeds
    upcasedBreed = breed.toUpperCase()
} println(upcasedBreed)

// esistono anche i while/ do while...

for (i <- 1 to 10) println(i)
