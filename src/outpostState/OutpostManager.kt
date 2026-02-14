package outpostState

class OutpostManager {
    private val _resources = mutableListOf<ObservableResource>()
    val resources: List<ObservableResource> get() = _resources

    init {
        println("OutpostManager инициализирован")
    }
    fun addResource(resource: ObservableResource) {
        _resources.add(resource)
    }
}

val outpostManager: OutpostManager by lazy {
    OutpostManager()
}