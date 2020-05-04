<template>
    <el-row>
        <el-col :span="24">
            <el-card class="box-card">
                <div slot="header" class="clearfix">
                    <span>TODOリスト</span>
                </div>
                <el-table
                        :data="todolist"
                        style="width: 100%">
                    <el-table-column
                            prop="id"
                            label="TodoID"
                            width="300"/>
                    <el-table-column
                            prop="name"
                            label="やること"
                            width="300"/>
                    <el-table-column
                            prop="deadline"
                            label="締め切り"
                            width="300"/>
                </el-table>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>
    import axios from 'axios'

    export default {
        name: "Todo",
        data(){
            return {
                todolist:[]
            }
        },
        created: async function() {
            await this.refresh()
        },
        methods:{
            refresh: async function(){
                const res = await axios.get('http://localhost:8080/')
                this.todolist = res.data.todoEntities
                console.log(this.todolist)
            }
        }
    }
</script>

<style>

</style>