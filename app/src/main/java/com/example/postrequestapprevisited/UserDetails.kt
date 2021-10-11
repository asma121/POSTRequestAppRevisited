package com.example.postrequestapprevisited

import com.google.gson.annotations.SerializedName

class UserDetails {
    @SerializedName("data")
    var data: List<Datum>? = null

    class Datum{
        @SerializedName("pk")
        var pk: String? = null

        @SerializedName("name")
        var name: String? = null

        @SerializedName("location")
        var location: String? = null

        constructor(name: String?, location: String?) {
            this.name = name
            this.location = location
        }
    }
}