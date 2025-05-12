<template>
    <div>
        <Number
            label="OrderItemId"
            v-model="value.orderItemId"
            :editMode="editMode"
        />
        <Number
            label="ProductId"
            v-model="value.productId"
            :editMode="editMode"
        />
        <Number
            label="Quantity"
            v-model="value.quantity"
            :editMode="editMode"
        />
        <StockId
            offline
            label="StockId"
            v-model="value.stockId"
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
    name: 'OrderItem',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "orderItems",
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
