// import {read} from 'to-vfile'
// import {unified} from 'unified'
// import remarkParse from 'remark-parse'
// import remarkGfm from 'remark-gfm'
// import remarkRehype from 'remark-rehype'
// import rehypeStringify from 'rehype-stringify'


// 加载markdown文件
const defaultMdFile = '/md/default.md'

const loadArticle = async (url) => {
    const res = await fetch(url);
    return await res.text()
}

const loadMarkdownFileByUrl = (url) => {
    return loadArticle(url)
}


const loadDefaultMarkdownFile = () => {
    return loadArticle(defaultMdFile)
}

// async function loadFileTest() {
//     const file = await unified()
//         .use(remarkParse)
//         .use(remarkGfm)
//         .use(remarkRehype)
//         .use(rehypeStringify)
//         .process(await read(defaultMdFile))
//
//     console.log("____________", String(file))
// }

export {
    loadDefaultMarkdownFile, loadMarkdownFileByUrl
}