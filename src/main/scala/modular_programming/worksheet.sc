import com.company.modular_programming.{SimpleBrowser, SimpleDatabase}

val apple = SimpleDatabase.foodNamed("Apple").get

SimpleBrowser.recipesUsing(apple)