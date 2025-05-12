<template>
    <div>
        <Number
            label="StockId"
            v-model="value.stockId"
            :editMode="editMode"
        />
        <Number
            label="Quantity"
            v-model="value.quantity"
            :editMode="editMode"
        />
        <Product
            offline
            label="Product"
            v-model="value.product"
            :editMode="editMode"
            @change="change"
        />
        <StockStatus
            offline
            label="Status"
            v-model="value.status"
            :editMode="editMode"
            @change="change"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Stock',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "stocks",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
