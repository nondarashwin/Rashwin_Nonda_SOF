package com.store.demo.model

import javax.persistence.*

@Entity
@Table(name = "Product")
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id = 0
    var name: String? = null
    var type: String? = null
    var info: String? = null
    var cost = 0
    var continuity = false

    constructor(id: Int, name: String?, type: String?, info: String?, cost: Int, continuity: Boolean) {
        this.id = id
        this.name = name
        this.type = type
        this.info = info
        this.cost = cost
        this.continuity = continuity
    }

    constructor() {}

    override fun toString(): String {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", info='" + info + '\'' +
                ", cost=" + cost +
                ", continuity=" + continuity +
                '}'
    }
}