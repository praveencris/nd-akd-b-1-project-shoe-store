package com.udacity.shoestore.shoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel() : ViewModel() {
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    val shoeListString = Transformations.map(shoeList) { shoeList ->
        var shoeListString = ""
        for (shoe in shoeList) {
            shoeListString += "Name: ${shoe.name}, Brand: ${shoe.company}, Size: ${shoe.size}\nDescription: ${shoe.description}\n\n\n"
        }
        shoeListString
    }


    init {
        initializeShoeList()
    }

    private fun initializeShoeList() {
        val shoeList: MutableList<Shoe> = mutableListOf(
            Shoe(
                "Sneakers",
                9.0,
                "Nike",
                "Sneakers are like the comfort food we all crave for. This lightweight and simple footwear are a must-have for everyone. They are not only comfortable but also go with every look. There are so many colors and patterns available that you can find a match for your every outfit. If you are planning on exploring the city and looking for a comfy pair of shoes, then sneakers are the way to go.",
                mutableListOf(
                    "https://footwearnews.com/wp-content/uploads/2019/11/jordan-melo-m12-555088_062_a_prem-e1575044740922.jpg?resize=700,437",
                    "https://assets.bwbx.io/images/users/iqjWHBFdfxIU/i4jPhKEFw1NE/v0/1000x-1.jpg"
                )
            ),
            Shoe(
                "Boots",
                8.0,
                "Adidas",
                "Boots are not only classy but stylish as well. They portray a regal style that suits everyone. No matter what you are wearing – tailored trousers, a denim skirt, or jeans, boots go with every look. There are different types of boots like ankle boots, calf boots, military boots, leather boots, and hiking boots.",
                mutableListOf(
                    "https://static.designboom.com/wp-content/uploads/2013/09/a-history-of-adidas-football-cleats-designboom01.jpg",
                    "https://www.lovellsoccer.co.uk/products/large/419728.jpg"
                )
            ),
            Shoe(
                "Flip-flops",
                7.0,
                "Adidas",
                "Flip-flops are the ultimate footwear for the summer season. Flip-flops are versatile and easy to manage. Not to mention the fact that you will not have to spend hours trying to get the sand out of them. Flip-flops are a popular choice of footwear for men, women, and children alike.",
                mutableListOf(
                    "https://assets.ajio.com/medias/sys_master/root/h4d/haa/14497404911646/-473Wx593H-460477204-black-MODEL.jpg",
                    "https://n1.sdlcdn.com/imgs/i/h/2/ADIDAS-2019-Black-Slide-Flip-SDL461139847-1-f9e27.jpg"
                )
            ),
            Shoe(
                "Slippers",
                10.0,
                "Woodland",
                "The summer ones could be furry, adorable, and comfy. While the winter one should have padding to keep your feet warm and cozy when you get out of your warm and comfy bed",
                mutableListOf(
                    "https://images-na.ssl-images-amazon.com/images/I/51IWQV-QmiL._UX500_.jpg",
                    "https://images-na.ssl-images-amazon.com/images/I/51u5gp1f1yL._UL1128_.jpg"
                )
            ),
            Shoe(
                "Crocs",
                9.0,
                "Puma",
                "This footwear is very popular among travel enthusiasts as they need comfy shoes during their hectic days.",
                mutableListOf(
                    "https://img5.cfcdn.club/fe/24/fec60b6b6048f7be29eb1e5494192224_350x350.jpg",
                    "https://media.karousell.com/media/photos/products/2016/11/08/puma_crocstyle_shoes_1478573482_0a36351b.jpg"
                )
            ),
            Shoe(
                "Cleats",
                11.0,
                "Spark",
                "If you enjoy playing sports, especially soccer, then you need to invest in some cleats. A lot of people wear their sneakers or joggers, but that is not right. Sure, they provide your feet with comfort, but cleats go one step further than that. It not only gives your feet the comfort it needs, but it also provides you with stability and speed. There will be no missed goals when you are playing soccer wearing your brand-new cleats. Cleats give you the much-needed traction on the soccer ground and will help you get the MVP award.",
                mutableListOf(
                    "https://assets.adidas.com/images/w_600,f_auto,q_auto/a747087f113b4de9b7e8a99c0109455c_9366/Adizero_Spark_Cleats_Black_CG6533_01_standard.jpg",
                    "https://dks.scene7.com/is/image/GolfGalaxy/20ADIMDZRSPRKBLKSCLT_White_Silver?qlt=70&wid=600&fmt=pjpeg"
                )
            )
        )
        _shoeList.value = shoeList
    }

}