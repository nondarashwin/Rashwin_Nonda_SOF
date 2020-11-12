package com.store.demo.model

import javax.persistence.*

@Entity
@Table(name = "Stores")
class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id = 0
    var name: String? = null
    var address: String? = null
    var isContinuity = false

    constructor(id: Int, name: String?, address: String?, continuity: Boolean) {
        this.id = id
        this.name = name
        this.address = address
        isContinuity = continuity
    }

    constructor() {}

    override fun toString(): String {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", continuity=" + isContinuity +
                '}'
    }
}